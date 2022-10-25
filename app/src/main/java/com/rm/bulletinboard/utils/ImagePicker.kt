package com.rm.bulletinboard.utils

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.rm.bulletinboard.R
import io.ak1.pix.helpers.*
import io.ak1.pix.models.Flash
import io.ak1.pix.models.Mode
import io.ak1.pix.models.Options
import io.ak1.pix.models.Ratio


object ImagePicker {
    const val REQUEST_CODE_GET_IMAGES = 999;


    val options = Options().apply {
        ratio = Ratio.RATIO_AUTO                           //Image/video соотношение захвата
        count = 3                                          //Количество изображений для ограничения выбора count
        spanCount = 4                                      //Количество столбцов в сетке
        path = "Pix/Camera"                                //Пользовательский путь для хранилища мультимедиа
        isFrontFacing = false                              //Фронтовая камера при запуске
        videoOptions.videoDurationLimitInSeconds = 10      //Длительность видео записи
        mode = Mode.All                                    //Возиможность выбора только изображения или видео или все сразу
        flash = Flash.Auto                                 //Возможность выбора место памяти
        preSelectedUrls = ArrayList<Uri>()                 //Предварительно выбранные URL-адреса изображений

    }
}