package com.ljq.protocol.basic.attribute;

import com.ljq.framework.codec.Field;
import com.ljq.framework.fields.FieldType;

public class TimeInfo {
    @Field(index = 0, type = FieldType.UINT32)
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Field(index = 1, type = FieldType.UINT8)
    public short getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(short timeZone) {
        this.timeZone = timeZone;
    }

    @Field(index = 2, type = FieldType.RESERVE, length = 3)
    public Byte getReserve() {
        return reserve;
    }

    public void setReserve(Byte reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "TimeInfo{" +
                "time=" + time +
                ", timeZone=" + timeZone +
                ", reserve=" + reserve +
                '}';
    }

    private long time;
    private short timeZone;
    private Byte reserve;
}
