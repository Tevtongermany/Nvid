package me.cortex.nvidium.renderers;

import me.cortex.nvidium.gl.shader.Shader;
import me.cortex.nvidium.sodiumCompat.ShaderLoader;

import net.minecraft.util.Identifier;

import static me.cortex.nvidium.gl.shader.ShaderType.*;
import static org.lwjgl.opengl.NVMeshShader.glDrawMeshTasksNV;

//TODO:FIXME: CLEANUP
public class SectionRasterizer extends Phase {

    private final Shader shader = Shader.make()
            .addSource(TASK, ShaderLoader.parse(new Identifier("nvidium", "occlusion/section_raster/task.glsl")))
            .addSource(MESH, ShaderLoader.parse(new Identifier("nvidium", "occlusion/section_raster/mesh.glsl")))
            .addSource(FRAGMENT, ShaderLoader.parse(new Identifier("nvidium", "occlusion/section_raster/fragment.glsl"))).compile();

    public void raster(int regionCount) {
        shader.bind();
        glDrawMeshTasksNV(0,regionCount);
    }

    public void delete() {
        shader.delete();
    }
}
