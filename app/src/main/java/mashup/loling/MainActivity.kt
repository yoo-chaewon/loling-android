package mashup.loling

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import mashup.loling.Fragment.FriendListFragment
import mashup.loling.model.FriendItem

class MainActivity : AppCompatActivity() {


    var friendItemList = arrayListOf<FriendItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      
      var fragment: FriendListFragment = FriendListFragment()
        supportFragmentManager.beginTransaction().add(R.id.frMainFriendList, fragment).commit()

    }

    
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //address permission
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "연락처 권한 주어져 있음.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "연락처 권한 없음.", Toast.LENGTH_LONG).show()

            //if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
            //    Toast.makeText(this, "SMS 권한 설명 필요함", Toast.LENGTH_LONG).show();
            //} else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
            //}
        }
    }
}
