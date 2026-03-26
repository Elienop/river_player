package ir.r3r.river_player

import android.content.Context
import android.view.SurfaceView
import android.view.View
import io.flutter.plugin.platform.PlatformView

internal class RiverPlayerPlatformView(
    context: Context,
    private val textureId: Long,
    private val playerLookup: (Long) -> RiverPlayer?
) : PlatformView {
    private val surfaceView = SurfaceView(context)

    init {
        val player = playerLookup(textureId)
        player?.setSurfaceView(surfaceView)
    }

    override fun getView(): View = surfaceView

    override fun dispose() {
        // Player lifecycle is managed by RiverPlayerPlugin
    }
}
