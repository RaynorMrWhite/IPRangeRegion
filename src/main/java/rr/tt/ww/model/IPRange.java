package rr.tt.ww.model;

import java.util.List;

public class IPRange {
    private String syncToken;
    private String createDate;
    private List<Ip_Prefix> prefixes;
    private List<Ipv6_Prefix> ipv6_prefixes;

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

    public List<Ip_Prefix> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(List<Ip_Prefix> ipPrefixes) {
        this.prefixes = ipPrefixes;
    }

    public List<Ipv6_Prefix> getIpv6_prefixes() {
        return ipv6_prefixes;
    }

    public void setIpv6_prefixes(List<Ipv6_Prefix> ipv6_prefixes) {
        this.ipv6_prefixes = ipv6_prefixes;
    }

}
