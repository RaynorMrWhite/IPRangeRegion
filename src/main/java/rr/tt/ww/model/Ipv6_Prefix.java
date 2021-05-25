package rr.tt.ww.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Ipv6_Prefix {

    private String ipv6_prefix;
    private String region;

    public String getIp_prefix() {
        return ipv6_prefix;
    }

    public void setIp_prefix(String ip_prefix) {
        this.ipv6_prefix = ip_prefix;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
