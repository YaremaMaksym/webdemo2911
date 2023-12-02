package com.yaremax.demo2911.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Track}
 */
public interface TrackInfo {
    Integer getId();

    @Value("#{target.name + ' by ' + target.composer}")
    String getFullTitle();

    Integer getMilliseconds();
}