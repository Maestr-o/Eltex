package com.eltex;

public record Coordinates(double lat, double longVal) {
    Builder builder() {
        return new Builder()
                .setLat(lat)
                .setLongVal(longVal);
    }

    static class Builder {
        private double lat = 0.0;
        private double longVal = 0.0;

        public Builder setLat(double lat) {
            this.lat = lat;
            return this;
        }

        public Builder setLongVal(double longVal) {
            this.longVal = longVal;
            return this;
        }

        public Coordinates build() {
            return new Coordinates(lat, longVal);
        }
    }
}