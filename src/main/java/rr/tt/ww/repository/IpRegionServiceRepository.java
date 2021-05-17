package rr.tt.ww.repository;

import rr.tt.ww.model.IPRange;

public interface IpRegionServiceRepository  {
    IPRange findbyregion(String region, IPRange ipRange);
}
