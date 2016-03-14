package com.godi.godigame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;

public class Assets {

    public static final AssetManager manager = new AssetManager();
    public static final String CaviarDreams_font = "data/CaviarDreams.ttf";
    public static final String rect_btn_pack = "texture/btn/rect_btn.pack";
    public static final String circle_btn_pack = "texture/btn/circle_btn.pack";
    public static final String circle_btn_small_pack = "texture/btn/circle_btn_small.pack";



    public static void load() {
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(new InternalFileHandleResolver()));
        manager.load(CaviarDreams_font, FreeTypeFontGenerator.class);
        manager.load(rect_btn_pack, TextureAtlas.class);
        manager.load(circle_btn_pack, TextureAtlas.class);
        manager.load(circle_btn_small_pack, TextureAtlas.class);

    }

    public static void dispose() {
        manager.dispose();
    }

    public static boolean update() {
        return manager.update();
    }
}