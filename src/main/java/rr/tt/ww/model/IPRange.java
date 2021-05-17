package rr.tt.ww.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class IPRange {
    private String syncToken;
    private String createDate;
    private List<Prefix> prefixes;
    private List<Ipv6_Prefix> ipv6_prefixes;

    public List<Ipv6_Prefix> getIpv6_prefixes() {
        return ipv6_prefixes;
    }

    public void setIpv6_prefixes(List<Ipv6_Prefix> ipv6_prefixes) {
        this.ipv6_prefixes = ipv6_prefixes;
    }

    public String getSyncToken() {
        return syncToken;
    }

    public void setSyncToken(String syncToken) {
        this.syncToken = syncToken;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Prefix> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(List<Prefix> prefixes) {
        this.prefixes = prefixes;
    }
}
