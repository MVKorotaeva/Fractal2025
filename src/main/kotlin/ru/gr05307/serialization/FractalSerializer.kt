package ru.gr05307.serialization

import ru.gr05307.painting.convertation.Plain
import org.json.JSONObject
import java.io.File

class FractalSerializer {

    fun save(plain: Plain, filePath: String) {
        val json = JSONObject()

        json.put("xMin", plain.xMin)
        json.put("xMax", plain.xMax)
        json.put("yMin", plain.yMin)
        json.put("yMax", plain.yMax)
        json.put("width", plain.width)
        json.put("height", plain.height)
        json.put("type", "mandelbrot")

        File(filePath).writeText(json.toString())
    }

    fun load(filePath: String): Plain {
        val json = JSONObject(File(filePath).readText())

        return Plain(
            xMin = json.getDouble("xMin"),
            xMax = json.getDouble("xMax"),
            yMin = json.getDouble("yMin"),
            yMax = json.getDouble("yMax"),
            width = json.getDouble("width").toFloat(),
            height = json.getDouble("height").toFloat()
        )
    }
}