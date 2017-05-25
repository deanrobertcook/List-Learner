package org.theronin

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.waz.threading.Threading
import com.waz.utils.events.Signal
import com.waz.utils.ui.ActivityHelper

class MainActivity extends ActivityHelper {

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    val button = findViewById(R.id.button).asInstanceOf[Button]
    val buttonPressed = Signal(false)


    button.setOnClickListener(new OnClickListener {
      override def onClick(v: View) = buttonPressed.mutate(!_)
    })

    buttonPressed.on(Threading.Ui) {
      case true => button.setText("Now I'm pressed, try again")
      case false => button.setText("Press me")
    }

  }



}
