package com.eltex;

public record Attachment(String url, AttachmentType type) {
    public enum AttachmentType {
        IMAGE,
        VIDEO,
        AUDIO,
    }

    Builder builder() {
        return new Builder()
                .setUrl(url)
                .setType(type);
    }

    static class Builder {
        private String url = "";
        private AttachmentType type = AttachmentType.AUDIO;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setType(AttachmentType type) {
            this.type = type;
            return this;
        }

        public Attachment build() {
            return new Attachment(url, type);
        }
    }
}
