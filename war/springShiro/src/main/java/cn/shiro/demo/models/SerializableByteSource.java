package cn.shiro.demo.models;

import org.apache.shiro.util.*;

import java.io.Serializable;

public class SerializableByteSource extends SimpleByteSource implements Serializable {
    private static final long serialVersionUID = -547788024411980990L;

    public SerializableByteSource (ByteSource source) {
        super(source);
    }

    public SerializableByteSource (String source) {
        this(ByteSource.Util.bytes(source));
    }
}
