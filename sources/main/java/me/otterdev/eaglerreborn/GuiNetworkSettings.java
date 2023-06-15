package me.otterdev.eaglerreborn;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.Keyboard;
import net.lax1dude.eaglercraft.v1_8.Mouse;
import net.minecraft.client.gui.GuiTextField;
import net.lax1dude.eaglercraft.v1_8.EaglerInputStream;
import net.minecraft.util.ResourceLocation;
import java.io.*;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.*;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import me.otterdev.eaglerreborn.NetworkSettings;

import java.io.IOException;

public class GuiNetworkSettings extends GuiScreen {
        private final GuiScreen parent;
        private GuiTextField relayField;
        private int scrollPos = -1;
        private int selectedSlot = 0;
        private int mousex = 0;
	private int mousey = 0;
	private int mx = 0;
	private int my = 0;
	private boolean dropDownOpen = false;
	private String[] dropDownOptions;
        protected String screenTitle = "Network Settings";
	private String relaything = "placeholder";
	byte[] relayStorage = EagRuntime.getStorage("relay");
	if (relayStorage == null) {
		return;
	}
	NBTTagCompound relay;
	try {
		relay = CompressedStreamTools.readCompressed(new EaglerInputStream(relayStorage));
	}catch(IOException ex) {
		return;
	}

	if (relay == null || relay.hasNoTags()) {
		return;
	}
	String loadRelay = relay.getString("relay");
	if(loadRelay.isEmpty()) {
		relaything = NetworkSettings.defaultRelay;
	}
        public GuiNetworkSettings(GuiScreen parent) {
		this.parent = parent;
	}
        public void initGui() {
		Keyboard.enableRepeatEvents(true);
                relayField = new GuiTextField(0, fontRendererObj, width / 2 - 20 + 1, height / 6 + 24 + 1, 138, 20);
		relayField.setFocused(true);
		relayField.setText(relaything);

        }

        public void drawScreen() {
                drawDefaultBackground();
                drawCenteredString(fontRendererObj, screenTitle, width / 2, 15, 16777215);
                drawString(fontRendererObj, "Relay", width / 2 - 20, height / 6 + 8, 10526880);
		mx = Mouse.getX();
		my = Mouse.getY();
                mousex = mx;
		mousey = my;
                relayField.drawTextBox();
        }
        public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		if(dropDownOpen) {
			int var1 = Mouse.getEventDWheel();
			if(var1 < 0) {
				scrollPos += 3;
			}
			if(var1 > 0) {
				scrollPos -= 3;
				if(scrollPos < 0) {
					scrollPos = 0;
				}
			}
		}
	}
        protected void actionPerformed(GuiButton par1GuiButton) {
                if(par1GuiButton.id == 0) {
				this.mc.displayGuiScreen((GuiScreen) parent);
			}

        }
        public void updateScreen() {
                relayField.updateCursorCounter();
        }
        public void onGuiClosed() {
		String name = relayField.getText();
		NBTTagCompound relay = new NBTTagCompound();
		relay.setString("relayurl", name);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		try {
			CompressedStreamTools.writeCompressed(relay, bao);
		} catch (IOException e) {
			return;
		}
		EagRuntime.setStorage("relay", bao.toByteArray());
		Keyboard.enableRepeatEvents(false);
	}
        protected void keyTyped(char c, int k) {
		relayField.textboxKeyTyped(c, k);
		
		String text = relayField.getText();
                if(k == 200 && selectedSlot > 0) {
			--selectedSlot;
			scrollPos = selectedSlot - 2;
		}
		if(k == 208 && selectedSlot < (dropDownOptions.length - 1)) {
			++selectedSlot;
			scrollPos = selectedSlot - 2;
		}
	}
        protected void mouseClicked(int mx, int my, int button) {
		super.mouseClicked(mx, my, button);
		relayField.mouseClicked(mx, my, button);
        }
	public static String relayURL() {
		return relaything;
	}

}
