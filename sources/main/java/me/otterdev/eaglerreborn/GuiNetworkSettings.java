package me.otterdev.eaglerreborn;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.Keyboard;
import net.lax1dude.eaglercraft.v1_8.Mouse;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.*;

import java.io.IOException;

public class GuiNetworkSettings extends GuiScreen {
        private final GuiScreen parent;
        private GuiTextField relayField;
        private int scrollPos = -1;
        private int selectedSlot = 0;
        private int mousex = 0;
	private int mousey = 0;
	private boolean dropDownOpen = false;
	private String[] dropDownOptions;
        protected String screenTitle = "Network Settings";
        public GuiNetworkSettings(GuiScreen parent) {
		this.parent = parent;
		updateOptions();
	}
        public void initGui() {
		Keyboard.enableRepeatEvents(true);
                relayField = new GuiTextField(0, fontRendererObj, width / 2 - 20 + 1, height / 6 + 24 + 1, 138, 20);
		relayField.setFocused(true);

        }

        public void drawScreen() {
                drawDefaultBackground();
                drawCenteredString(fontRendererObj, screenTitle, width / 2, 15, 16777215);
                drawString(fontRendererObj, "Relay", width / 2 - 20, height / 6 + 8, 10526880);
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

}
