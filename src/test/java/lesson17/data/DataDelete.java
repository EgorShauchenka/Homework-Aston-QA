package lesson17.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDelete {

    public Args args;
    public Object data;
    public Files files;
    public Form form;
    public Headers headers;
    public Object json;
    public String url;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Args {
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Files {
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Form {
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Headers {
        @JsonProperty("x-forwarded-proto")
        public String xForwardedProto;
        @JsonProperty("x-forwarded-port")
        public String xForwardedPort;
        public String host;
        @JsonProperty("x-amzn-trace-id")
        public String xAmznTraceId;
        @JsonProperty("content-length")
        public String contentLength;
        @JsonProperty("content-type")
        public String contentType;
        @JsonProperty("user-agent")
        public String userAgent;
        public String accept;
        @JsonProperty("cache-control")
        public String cacheControl;
        @JsonProperty("postman-token")
        public String postmanToken;
        @JsonProperty("accept-encoding")
        public String acceptEncoding;
        public String cookie;
    }
}
