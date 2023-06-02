package net.lax1dude.eaglercraft.v1_8.internal.teavm;

import net.lax1dude.eaglercraft.v1_8.internal.IBufferArrayGL;
import net.lax1dude.eaglercraft.v1_8.internal.IBufferGL;
import net.lax1dude.eaglercraft.v1_8.internal.IProgramGL;
import net.lax1dude.eaglercraft.v1_8.internal.IShaderGL;
import net.lax1dude.eaglercraft.v1_8.internal.ITextureGL;
import net.lax1dude.eaglercraft.v1_8.internal.PlatformAssets;
import net.lax1dude.eaglercraft.v1_8.internal.PlatformInput;
import net.lax1dude.eaglercraft.v1_8.internal.PlatformRuntime;
import net.lax1dude.eaglercraft.v1_8.internal.buffer.ByteBuffer;
import net.lax1dude.eaglercraft.v1_8.internal.buffer.FloatBuffer;
import net.lax1dude.eaglercraft.v1_8.internal.buffer.IntBuffer;
import net.lax1dude.eaglercraft.v1_8.opengl.ImageData;

import static net.lax1dude.eaglercraft.v1_8.internal.PlatformOpenGL.*;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.*;

import net.lax1dude.eaglercraft.v1_8.Base64;
import net.lax1dude.eaglercraft.v1_8.EagUtils;

/**
 * Copyright (c) 2022-2023 LAX1DUDE. All Rights Reserved.
 * 
 * WITH THE EXCEPTION OF PATCH FILES, MINIFIED JAVASCRIPT, AND ALL FILES
 * NORMALLY FOUND IN AN UNMODIFIED MINECRAFT RESOURCE PACK, YOU ARE NOT ALLOWED
 * TO SHARE, DISTRIBUTE, OR REPURPOSE ANY FILE USED BY OR PRODUCED BY THE
 * SOFTWARE IN THIS REPOSITORY WITHOUT PRIOR PERMISSION FROM THE PROJECT AUTHOR.
 * 
 * NOT FOR COMMERCIAL OR MALICIOUS USE
 * 
 * (please read the 'LICENSE' file this repo's root directory for more info)
 * 
 */
public class EarlyLoadScreen {

	public static final String loadScreen = "/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAQwAABtbnRyUkdCIFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAAAADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlkZXNjAAAA8AAAAHRyWFlaAAABZAAAABRnWFlaAAABeAAAABRiWFlaAAABjAAAABRyVFJDAAABoAAAAChnVFJDAAABoAAAAChiVFJDAAABoAAAACh3dHB0AAAByAAAABRjcHJ0AAAB3AAAADxtbHVjAAAAAAAAAAEAAAAMZW5VUwAAAFgAAAAcAHMAUgBHAEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhZWiAAAAAAAABvogAAOPUAAAOQWFlaIAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z3BhcmEAAAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABYWVogAAAAAAAA9tYAAQAAAADTLW1sdWMAAAAAAAAAAQAAAAxlblVTAAAAIAAAABwARwBvAG8AZwBsAGUAIABJAG4AYwAuACAAMgAwADEANv/bAEMAAwICAwICAwMDAwQDAwQFCAUFBAQFCgcHBggMCgwMCwoLCw0OEhANDhEOCwsQFhARExQVFRUMDxcYFhQYEhQVFP/bAEMBAwQEBQQFCQUFCRQNCw0UFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFP/AABEIAQABAAMBIgACEQEDEQH/xAAeAAEAAgMBAAMBAAAAAAAAAAAACAkFBgcEAQIDCv/EAEQQAAEDBAECAwUGAwQGCwAAAAEAAgMEBQYRBxIhCBMxCRQiQVEVFiMyYXFCgZEXJKGxGCUzUmJ0NjhTVHOCkrK0wdH/xAAbAQEAAgMBAQAAAAAAAAAAAAAABAUBAwYCB//EACkRAQEAAgEDAgMJAAAAAAAAAAABAhEDBBIhMUEFMlETIiNCYXGBkfH/2gAMAwEAAhEDEQA/ALU0REBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAReK6Xq32On8+419Nb4P+1qpmxt/q4gL6WO/wBsya3MuFouFNdKF7nNZU0crZY3FpIcA5pIOiCP5IMgix15yK1Y5AJ7tc6O2Qn0krJ2RNP83EL9bReKG/26C4WysguFDOOqKpppBJHIN621w7HuCg9iIiAiIgIiICLWeRMZvOW4zNb7DlNZh1zc9r47rRU8M72a/hLJWuaQfn239CFWX4TvF5zNm/ijxPDcnzme72WorqmCqpnUdMwShkMpHxNjDgOpgPY/JBa0iIgIiICIiAiIgqQsGC2qy0zZPIa4AflDe5W7WgWuljE0dul2D30xdUw1uIzUEc756OYAfnc4aWblzDDqOTyoJKOXZ6SYulxb/LY2vlPZeVZdljCYzDT3aEMiaY3hrS6KRpa9oIBGwe42CD+xXtqcGkdUsMZ7uPosvyLijeQOOvfMfr32XJrbEZLfdaaLy3xgb0yRhJEkBJALDv8ANtpDgFDCXxxci4VaJY71Q2Woro5ZI2VDo366mEtcAAWhw6gdEegB2Oyk9P8AD+TK6lla+SSzekq824uparG6msL2QPpY3SSSyEBrWtGyST2AAC4JxxW49yTWXSlszn1Ffb9OfTzR+W97D6SNB7lu9eoBGxsBfON+KrIs5xKjdcrZCy23yQwNjaySF9RHHp0z2E9X4Z2xuy3RDnDfZcMufJsfFnL7sntM7KVrvNgqPdZRO0sd26XANb0lpAOnD5A7+SnzocpMsL83tr0MOLDPG2+HeMh4KvF3kdNLTCnhHoCew/dalU8FVdPbZZWmKUM3vp7kBdsx2kyDm3CKerpMqbHDVN0WQgBw+oP6+q8td4achxSyzsp8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FKSiulrrZ6h76uMiEyxSQeYwvdCwPYyIFrixvk+hAXKrDgmd2ix57S0ON5BBhVZerNW1ljobZJbn19qLZ210VLTGZ7mPf0QNc0SiRzA3rI6ulBNvIcpteKQ0Mt1qvdY62tgt9OfLc/rnmeGRs+EHW3EDZ0B8yF+GVZV91vsf/U91u/2jcYbd/qqm8/3XzN/jzdx0Qt18T++tjt3Udc/4iw3KuM8fueP8ZXOmpLPkFPUTWye2ywVrqLzWGrDIHHre1zAfgA7kEgfNfTlmlxdtFxbJjPGOSiWyXWhuVM634xVRmgpG1RdURvHQCHkxucWOBLi9rxsP6iEqkUQ+ROManNXcx5rDYcjF7c21V2MsMVTBNDM2ip3GWGJuj57XDocdFzTGW9viBw1JjFgybmue45vFcIYoM3nbQXCrstXWMrnNndDTUjbi2V0LIRKR+CYm9HlFjnbBJCaq0rjfmHF+WH3hmOVr6p9qmbFUNkidGS14Lo5W79Y3gEtd8wCvVyrkNzxTjjI7rZaGruV6p6KT3CloqR1VI+ocOmL8NoJc0Pc0u+jQSewUYK3jnPMCtsuOXeiqKS1XjEoLILhxtST1lTFU0MrXR1FQTHFoSMnnDmB25Wtcxp6iNhMpFDWHEbnWcN3jHnYrfcasUV8pKmkrrBjs0T7ruDU4rbS6cymLcYYdPDXl8Tg0NY5eTLMQzLIuPMJt8uHVeN4fbLjdBPb7XY31jKqJxY6jqJLYZ/Oj6jJPthe8se3qOg5ugl/dMptdmvNmtNZVeTcLxJLFQw+W53nOjjdK8bAIbpjXH4iN60O/ZZZQ8r+DrZR45xPfshxu+57FbnVlPeqmptU32nPTPZP7q2Wk63yEMe6No7kta0flHwj18g41UUnLdHkOLYde8nlp47WbPj93x+aK3UrYxE7dHV+ZGy36YO8c0Z6ZY3dTdFuglwi1T74XP+1P7rfdyr+x/sX7T+8W3e7+f5/l+6/k6evp/E/PvX8Ou6Y7mFzvOd5dYqrHKu226y+5+53iYu8m5+dEXyeXtgH4bgGnTndz36fRBtaLVMAzC55f94/tLHKvHfsu9VNspvei7+/QR9PRVM6mN+B/Uda6h8J04ra0BERAREQEREBERAREQEREBERAREQEREBERAXP6XgPAaPL5snjx2J14lrTcnSSzyyQiqJ2ahsLnmJsu+4eGhwPcHa6AiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiD/2Q==";
	public static final String enableScreen = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAC4jAAAuIwF4pT92AAAEAklEQVR42u2dvXbjIBBG7T0+xw+gTp06v//LmE6dO/VR5a3wGZNh+BGSFeveJgkIBrDy8TGKds8/Pz/PExyW8/P55AY4MP9YgmNzmeeZVUABAA8AKADgAQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAY7LOI7fpQDX65VPtZCt18w5d7rdbigAbOgBxnE8DcPwJnnDMCTrNJlsUVcizTnj9HWxeVvINfN9y361OdTEk30551ZZt3PsvYDYxOSChoPQ6sJ21mRLBm61jY0lpy61gDKWNdfcNcv5wErWLbfPF88I9/s9WtayzopXS85YtPqcMeT23SqedV1pucal1V4iTUooV/IaWSfbWHU5JmkvpmzrsayaB9DqfJnVTpMff72sc869/WzVlcjjOI7mOOVYfBzfT05exLfT5pqae008a71Ly6tPASV79CfPylvFjpm+teLH+tXiF5nA2LOAUMpCibckWpPBUOJT20btFuDjyK8p+S45Z4fX+ti+LDb3pef62PosWbfkDbBW8mFPhB/gt8Vr7gG+kZK9+C/GM2+ArffnnKRHbT5gSdJoK0+ydrziGyCW115LolLxnHOr59q3lt89b6U8Czg4pgdI5bUtKY3VzfOclGBtTLVSmmqn1cdyC7Iud+5791KX1MLJDz3Mg2s59pK6sM/asdTmLrRx5pzjS+e+awWw9lstVeuv1/a10rqwT8sn5LQr8RzaMVfmKrR2qfnFjs57/puLS0nyoTZp0fL8XGq+ap8v4AES+3Msx74kN2/tmblewWoXPl9o+RykZH5/5hTQYv+y+vj084XcPHpJbHmt1s7yGbV1q+UBnHO/gnoZje2RmuzK/Vr2F3sWEF6TGkvutqH5CG08qTmk5u77tLyK5Qtq62rgxRA8AO8FHBkygQeHLQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAQAPACgA4AEABQA8AKAAgAcAFAC+3gNM03Tqum7VQSyN4dtvMdZDKcBWC9oqhr8JoIEHeDwep77vf5VJfL0vl9fLa/u+f+vPfx9eszSGNXZo5AH6vlcXW36gsqykrzViwAIPYL3r3nXd63v5m6i9J2+VaT8viWGNHZQbYE97+KdjHPIGKH0XPSyL7eXSjPk2YZlsN03Tq21OjLAs598ZggIT2MpMbW3IMICFN0Dsv4xpfUbfAvIAK9wAcOAtAMgDwJHzAIACAB4AUADAAwAKAHgAQAEADwAoAOABAAUAPACgAIAHABQA8ACAAgAeAFAAwAMACgB4AEABAA8AKADgAQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAQAPACgA4AEABQA8AKAAgAcAFADwANCe/0of1jQ8XY5YAAAAAElFTkSuQmCC";

	private static IBufferGL vbo = null;
	private static IProgramGL program = null;
	
	public static void paintScreen() {
		
		ITextureGL tex = _wglGenTextures();
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		
		ImageData img = PlatformAssets.loadImageFile(Base64.decodeBase64(loadScreen));
		ByteBuffer upload = PlatformRuntime.allocateByteBuffer(192*192*4);
		IntBuffer pixelUpload = upload.asIntBuffer();
		pixelUpload.put(img.pixels);
		pixelUpload.flip();
		_wglTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, 192, 192, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixelUpload);
		
		FloatBuffer vertexUpload = upload.asFloatBuffer();
		vertexUpload.clear();
		vertexUpload.put(0.0f); vertexUpload.put(0.0f);
		vertexUpload.put(0.0f); vertexUpload.put(1.0f);
		vertexUpload.put(1.0f); vertexUpload.put(0.0f);
		vertexUpload.put(1.0f); vertexUpload.put(0.0f);
		vertexUpload.put(0.0f); vertexUpload.put(1.0f);
		vertexUpload.put(1.0f); vertexUpload.put(1.0f);
		vertexUpload.flip();
			
		vbo = _wglGenBuffers();
		_wglBindBuffer(GL_ARRAY_BUFFER, vbo);
		_wglBufferData(GL_ARRAY_BUFFER, vertexUpload, GL_STATIC_DRAW);
		
		PlatformRuntime.freeByteBuffer(upload);

		IShaderGL vert = _wglCreateShader(GL_VERTEX_SHADER);
		_wglShaderSource(vert, "#version 300 es\nprecision lowp float; in vec2 a_pos; out vec2 v_pos; void main() { gl_Position = vec4(((v_pos = a_pos) - 0.5) * vec2(2.0, -2.0), 0.0, 1.0); }");
		_wglCompileShader(vert);
		
		IShaderGL frag = _wglCreateShader(GL_FRAGMENT_SHADER);
		_wglShaderSource(frag, "#version 300 es\nprecision lowp float; in vec2 v_pos; out vec4 fragColor; uniform sampler2D tex; uniform vec2 aspect; void main() { fragColor = vec4(texture(tex, clamp(v_pos * aspect - ((aspect - 1.0) * 0.5), 0.02, 0.98)).rgb, 1.0); }");
		_wglCompileShader(frag);
		
		program = _wglCreateProgram();
		
		_wglAttachShader(program, vert);
		_wglAttachShader(program, frag);
		_wglBindAttribLocation(program, 0, "a_pos");
		_wglLinkProgram(program);
		_wglDetachShader(program, vert);
		_wglDetachShader(program, frag);
		_wglDeleteShader(vert);
		_wglDeleteShader(frag);
		
		_wglUseProgram(program);
		_wglUniform1i(_wglGetUniformLocation(program, "tex"), 0);

		int width = PlatformInput.getWindowWidth();
		int height = PlatformInput.getWindowHeight();
		float x, y;
		if(width > height) {
			x = (float)width / (float)height;
			y = 1.0f;
		}else {
			x = 1.0f;
			y = (float)height / (float)width;
		}
		
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		
		_wglViewport(0, 0, width, height);
		_wglClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		_wglClear(GL_COLOR_BUFFER_BIT);
		
		_wglUniform2f(_wglGetUniformLocation(program, "aspect"), x, y);
		
		IBufferArrayGL vao = _wglGenVertexArrays();
		_wglBindVertexArray(vao);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 2, GL_FLOAT, false, 8, 0);
		_wglDrawArrays(GL_TRIANGLES, 0, 6);
		_wglDisableVertexAttribArray(0);
		
		PlatformInput.update();
		EagUtils.sleep(50l); // allow webgl to flush

		_wglUseProgram(null);
		_wglBindBuffer(GL_ARRAY_BUFFER, null);
		_wglBindTexture(GL_TEXTURE_2D, null);
		_wglDeleteTextures(tex);
		_wglDeleteVertexArrays(vao);
	}
	
	public static void paintEnable() {
		
		ITextureGL tex = _wglGenTextures();
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		ImageData img = PlatformAssets.loadImageFile(Base64.decodeBase64(enableScreen));
		IntBuffer upload = PlatformRuntime.allocateIntBuffer(128*128);
		upload.put(img.pixels);
		upload.flip();
		_wglTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, 128, 128, 0, GL_RGBA, GL_UNSIGNED_BYTE, upload);
		
		PlatformRuntime.freeIntBuffer(upload);
		
		_wglUseProgram(program);

		int width = PlatformInput.getWindowWidth();
		int height = PlatformInput.getWindowHeight();
		float x, y;
		if(width > height) {
			x = (float)width / (float)height;
			y = 1.0f;
		}else {
			x = 1.0f;
			y = (float)height / (float)width;
		}
		
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		
		_wglViewport(0, 0, width, height);
		_wglClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		_wglClear(GL_COLOR_BUFFER_BIT);
		
		_wglUniform2f(_wglGetUniformLocation(program, "aspect"), x, y);

		IBufferArrayGL vao = _wglGenVertexArrays();
		_wglBindVertexArray(vao);
		_wglBindBuffer(GL_ARRAY_BUFFER, vbo);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 2, GL_FLOAT, false, 8, 0);
		_wglDrawArrays(GL_TRIANGLES, 0, 6);
		_wglDisableVertexAttribArray(0);
		
		PlatformInput.update();
		EagUtils.sleep(50l); // allow webgl to flush

		_wglUseProgram(null);
		_wglBindBuffer(GL_ARRAY_BUFFER, null);
		_wglBindTexture(GL_TEXTURE_2D, null);
		_wglDeleteTextures(tex);
		_wglDeleteVertexArrays(vao);
		
	}
	
	public static void paintFinal(byte[] image) {
		ITextureGL tex = _wglGenTextures();
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		_wglTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		ImageData img = PlatformAssets.loadImageFile(image);
		IntBuffer upload = PlatformRuntime.allocateIntBuffer(256*256);
		upload.put(img.pixels);
		upload.flip();
		_wglTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, 256, 256, 0, GL_RGBA, GL_UNSIGNED_BYTE, upload);
		
		PlatformRuntime.freeIntBuffer(upload);
		
		_wglUseProgram(program);

		int width = PlatformInput.getWindowWidth();
		int height = PlatformInput.getWindowHeight();
		float x, y;
		if(width > height) {
			x = (float)width / (float)height;
			y = 1.0f;
		}else {
			x = 1.0f;
			y = (float)height / (float)width;
		}
		
		_wglActiveTexture(GL_TEXTURE0);
		_wglBindTexture(GL_TEXTURE_2D, tex);
		
		_wglViewport(0, 0, width, height);
		_wglClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		_wglClear(GL_COLOR_BUFFER_BIT);
		
		_wglUniform2f(_wglGetUniformLocation(program, "aspect"), x, y);

		IBufferArrayGL vao = _wglGenVertexArrays();
		_wglBindVertexArray(vao);
		_wglBindBuffer(GL_ARRAY_BUFFER, vbo);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 2, GL_FLOAT, false, 8, 0);
		_wglDrawArrays(GL_TRIANGLES, 0, 6);
		_wglDisableVertexAttribArray(0);
		
		PlatformInput.update();
		EagUtils.sleep(50l); // allow webgl to flush

		_wglUseProgram(null);
		_wglBindBuffer(GL_ARRAY_BUFFER, null);
		_wglBindTexture(GL_TEXTURE_2D, null);
		_wglDeleteTextures(tex);
		_wglDeleteVertexArrays(vao);
		_wglDeleteBuffers(vbo);
		_wglDeleteProgram(program);
	}
	
}
