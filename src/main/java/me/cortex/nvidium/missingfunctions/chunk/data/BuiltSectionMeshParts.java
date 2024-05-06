package me.cortex.nvidium.missingfunctions.chunk.data;


import me.cortex.nvidium.missingfunctions.gl.util.VertexRange;
import me.jellysquid.mods.sodium.client.util.NativeBuffer;

public class BuiltSectionMeshParts {
    private final VertexRange[] ranges;
    private final NativeBuffer buffer;

    public BuiltSectionMeshParts(NativeBuffer buffer, VertexRange[] ranges) {
        this.ranges = ranges;
        this.buffer = buffer;
    }

    public NativeBuffer getVertexData() {
        return this.buffer;
    }

    public VertexRange[] getVertexRanges() {
        return this.ranges;
    }
}