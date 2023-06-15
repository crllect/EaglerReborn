package me.otterdev.eaglerreborn;

import me.otterdev.eaglerreborn.NetworkSettings;
import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.Keyboard;
import net.lax1dude.eaglercraft.v1_8.Mouse;
import net.lax1dude.eaglercraft.v1_8.internal.FileChooserResult;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.ImageData;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.*;

import java.io.IOException;

public class GuiNetworkSettings extends GuiScreen {
  private final GuiScreen parent;
  private GuiTextField relaything;
  private boolean dropDownOpen = false;
	private String[] dropDownOptions;
	private int slotsVisible = 0;
	private int selectedSlot = 0;
	private int scrollPos = -1;
	private int skinsHeight = 0;
	private boolean dragging = false;
	private int mousex = 0;
	private int mousey = 0;

	private boolean newSkinWaitSteveOrAlex = false;
  private static final ResourceLocation eaglerGui = new ResourceLocation("eagler:gui/eagler_gui.png");
  protected String screenTitle = "Network Settings";
  public GuiNetworkSettings(GuiScreen parent) {
		this.parent = parent;
		updateOptions();
	}
  public void initGui() {
		Keyboard.enableRepeatEvents(true);
		screenTitle = I18n.format("menu.options");
		relaything = new GuiTextField(0, fontRendererObj, width / 2 - 20 + 1, height / 6 + 24 + 1, 138, 20);
		relaything.setFocused(true);
		relaything.setText(NetworkSettings.defaultRelay);
    buttonList.add(new GuiButton(0, width / 2 - 100, height / 6 + 168, I18n.format("gui.done")));
	}
  public void drawScreen(int mx, int my, float partialTicks) {
		drawDefaultBackground();
		drawCenteredString(fontRendererObj, screenTitle, width / 2, 15, 16777215);
		drawString(fontRendererObj, I18n.format("editProfile.username"), width / 2 - 20, height / 6 + 8, 10526880);
		
		mousex = mx;
		mousey = my;
		
		

		
		relaything.drawTextBox();
		if(dropDownOpen ||  newSkinWaitSteveOrAlex) {
			super.drawScreen(0, 0, partialTicks);
		}else {
			super.drawScreen(mx, my, partialTicks);
		}
		
		skinX = width / 2 - 20;
		skinY = height / 6 + 82;
		skinWidth = 140;
		skinHeight = 22;
		
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		
		mc.getTextureManager().bindTexture(eaglerGui);

		
		
		
		

		int xx = width / 2 - 80;
		int yy = height / 6 + 130;
		
		
	}


	public void updateScreen() {
		relaything.updateCursorCounter();	
	}
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	protected void keyTyped(char c, int k) {
		relaything.textboxKeyTyped(c, k);
		
		String text = relaything.getText();
		if(text.length() > 16) text = text.substring(0, 16);
		relaything.updateText(text);
		
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
		relaything.mouseClicked(mx, my, button);
		if (button == 0) {
			if(newSkinWaitSteveOrAlex) {
				int skinX = width / 2 - 90;
				int skinY = height / 4;
				int skinWidth = 70;
				int skinHeight = 120;
			
					return;
				}
				}
				return;
			}
			int skinX = width / 2 + 140 - 40;
			int skinY = height / 6 + 82;
		
			if(mx >= skinX && mx < (skinX + 20) && my >= skinY && my < (skinY + 22)) {
				dropDownOpen = !dropDownOpen;
				return;
			}
			
			skinX = width / 2 - 20;
			skinY = height / 6 + 82;
			int skinWidth = 140;
			int skinHeight = skinsHeight;
			
			if(!(mx >= skinX && mx < (skinX + skinWidth) && my >= skinY && my < (skinY + skinHeight + 22))) {
				dropDownOpen = false;
				dragging = false;
				return;
			}
			
			skinY += 21;
			
			if(dropDownOpen && !dragging) {
				for(int i = 0; i < slotsVisible; i++) {
					if(i + scrollPos < dropDownOptions.length) {
						if(selectedSlot != i + scrollPos) {
							if(mx >= skinX && mx < (skinX + skinWidth - 10) && my >= (skinY + i * 10 + 5) && my < (skinY + i * 10 + 15) && selectedSlot != i + scrollPos) {
								selectedSlot = i + scrollPos;
								dropDownOpen = false;
								dragging = false;
							}
						}
					}
				}
			}
		}
	}
		
	
}
