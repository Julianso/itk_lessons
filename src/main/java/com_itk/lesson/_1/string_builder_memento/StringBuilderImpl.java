package com_itk.lesson._1.string_builder_memento;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

final class StringBuilderImpl implements ExtStringBuilder {

    private java.lang.StringBuilder builder;

    private Snapshots snapshots = new Snapshots();

    StringBuilderImpl(StringBuilder builder) {
        this.builder = builder;
    }

    @Override
    public ExtStringBuilder append(String str) {
        builder.append(str);
        snapshots.addSnapshot(builder.toString());
        return this;
    }

    @Override
    public void undo() {
        builder = new StringBuilder(snapshots.popSnapshot());
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((builder == null) ? 0 : builder.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StringBuilderImpl other = (StringBuilderImpl) obj;
        if (builder == null) {
            if (other.builder != null) {
                return false;
            }
        } else if (!builder.toString().equals(other.builder.toString())) {
            return false;
        }
        return true;
    }


    static class Snapshots {

        private ArrayDeque<String> snapshots;

        public Snapshots() {
            this.snapshots = new ArrayDeque<>();
        }

        public void addSnapshot(String memento) {
            this.snapshots.add(memento);
        }

        public String popSnapshot() {
            try {
                this.snapshots.removeLast();
                return this.snapshots.getLast();
            } catch (NoSuchElementException e) {
                return "";
            }
        }
    }
}
