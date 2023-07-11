--- net/minecraft/client/gui/GuiMainMenu.java
+++ net/minecraft/client/gui/GuiMainMenu.java
@@ -155,6 +155,8 @@
 			this.splashText = "Happy new year!";
 		} else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31) {
 			this.splashText = "OOoooOOOoooo! Spooky!";
+		} else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 9) {
+			this.splashText = "nice";
 		}
 
 		int i = this.height / 4 + 48;
@@ -169,8 +171,7 @@
 
 		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, i + 72 + 12, 98, 20,
 				I18n.format("menu.options", new Object[0])));
-		this.buttonList.add(new GuiButton(4, this.width / 2 + 2, i + 72 + 12, 98, 20,
-				"Edit Profile"));
+		this.buttonList.add(new GuiButton(4, this.width / 2 + 2, i + 72 + 12, 98, 20, "Edit Profile"));
 
 		this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, i + 72 + 12));
 
@@ -191,8 +192,9 @@
 	}
 
 	private void addSingleplayerMultiplayerButtons(int parInt1, int parInt2) {
-		//testing
-		this.buttonList.add(new GuiButton(1, this.width / 2 - 100, parInt1, I18n.format("menu.playdemo", new Object[0])));
+		// testing
+		this.buttonList
+				.add(new GuiButton(1, this.width / 2 - 100, parInt1, I18n.format("menu.playdemo", new Object[0])));
 		// idk what tf this is
 		this.buttonList.add(new GuiButton(2, this.width / 2 - 100, parInt1 + parInt2 * 0,
 				I18n.format("menu.multiplayer", new Object[0])));
