package com.mrzak34.thunderhack.modules.player;

import com.mrzak34.thunderhack.events.PacketEvent;
import com.mrzak34.thunderhack.modules.Module;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.mrzak34.thunderhack.util.MovementUtil.isMoving;

public class NoServerRotation extends Module {
    public NoServerRotation() {
        super("NoServerRotation", "Тебе не вертит бошку", Category.PLAYER);
    }
  //  public Setting<Float> ddd2 = this.register(new Setting<>("TrgtRange", 1.0f, 1f, 360.0f));


    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onReceivePacket(PacketEvent.Receive event) {
            if(fullNullCheck()){
                return;
            }
            if (event.getPacket() instanceof SPacketPlayerPosLook) {
                SPacketPlayerPosLook sp = (SPacketPlayerPosLook) event.getPacket();
                sp.yaw = (mc.player.rotationYaw);
                sp.pitch = (mc.player.rotationPitch);
            }
        //SPacketEntityHeadLook
    }


    //
}
