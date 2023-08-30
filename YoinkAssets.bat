echo off
rem fun fact: this is perfectly legal
echo "Yoinking assets.."
echo wget -O mcp918/1.8.8.jar https://launcher.mojang.com/mc/game/1.8.8/client/0983f08be6a4e624f5d85689d1aca869ed99c738/client.jar | PowerShell.exe -noprofile -
echo wget -O mcp918/1.8.json https://launchermeta.mojang.com/mc/assets/1.8/e264980ad255aad2174cbe4d674c102474ae5202/1.8.json | PowerShell.exe -noprofile -
echo wget -O mcp918/mcp918.zip http://www.modcoderpack.com/files/mcp918.zip | PowerShell.exe -noprofile -
echo "Done!"
