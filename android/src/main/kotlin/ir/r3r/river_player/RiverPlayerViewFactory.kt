package ir.r3r.river_player

import android.content.Context
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

internal class RiverPlayerViewFactory(
    private val playerLookup: (Long) -> RiverPlayer?
) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        val params = args as Map<*, *>
        val textureId = (params["textureId"] as Number).toLong()
        return RiverPlayerPlatformView(context, textureId, playerLookup)
    }
}
