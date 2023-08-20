
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 4  @  2 : 3

~ import net.lax1dude.eaglercraft.v1_8.EagRuntime;
~ import net.lax1dude.eaglercraft.v1_8.vfs.SYS;

> DELETE  4  @  4 : 21

> DELETE  2  @  2 : 3

> INSERT  3 : 4  @  3

+ import net.zxmushroom63.plugins.PluginGUI;

> INSERT  9 : 11  @  9

+ 	private GuiButton notSoSuperSecret;
+ 	private GuiButton broadcastSettings;

> INSERT  25 : 29  @  25

+ 		GuiButton pluginsButton = new GuiButton(9635329, 0, 0, 100, 20, "Plugins");
+ 		this.buttonList.add(pluginsButton);
+ 		++i;
+ 

> CHANGE  21 : 23  @  21 : 23

~ 		this.buttonList.add(notSoSuperSecret = new GuiButton(8675309, this.width / 2 + 5, this.height / 6 + 48 - 6, 150,
~ 				20, "Super Secret Settings...") {

> CHANGE  13 : 16  @  13 : 15

~ 		this.buttonList.add(broadcastSettings = new GuiButton(107, this.width / 2 + 5, this.height / 6 + 72 - 6, 150,
~ 				20, I18n.format(EagRuntime.getRecText(), new Object[0])));
~ 		broadcastSettings.enabled = EagRuntime.recSupported();

> CHANGE  8 : 10  @  8 : 9

~ 		GuiButton rp;
~ 		this.buttonList.add(rp = new GuiButton(105, this.width / 2 - 155, this.height / 6 + 144 - 6, 150, 20,

> CHANGE  1 : 3  @  1 : 2

~ 		GuiButton b;
~ 		this.buttonList.add(b = new GuiButton(104, this.width / 2 + 5, this.height / 6 + 144 - 6, 150, 20,

> INSERT  1 : 2  @  1

+ 		b.enabled = false;

> INSERT  2 : 4  @  2

+ 
+ 		rp.enabled = SYS.VFS != null;

> CHANGE  22 : 23  @  22 : 23

~ 	protected void actionPerformed(GuiButton parGuiButton) {

> CHANGE  32 : 33  @  32 : 33

~ 				notSoSuperSecret.displayString = "Nope!";

> DELETE  22  @  22 : 27

> CHANGE  16 : 18  @  16 : 23

~ 				EagRuntime.toggleRec();
~ 				broadcastSettings.displayString = I18n.format(EagRuntime.getRecText(), new Object[0]);

> INSERT  2 : 5  @  2

+ 			if (parGuiButton.id == 9635329) {
+ 				PluginGUI.displayGui();
+ 			}

> EOF
