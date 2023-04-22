package com.aaronman.arrow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.ArucoDetector;


public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private static CameraBridgeViewBase cameraBridgeViewBase;
    private static BaseLoaderCallback baseLoaderCallback;
    private int screen_w;
    private  int screen_h;
    private Mat mRgba;
    private Mat gray;
    private int img_id;
    private Bitmap img;
    private Mat mat_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getting cam permission
        getPermission();

        cameraBridgeViewBase = (CameraBridgeViewBase) findViewById(R.id.fd_activity_surface_view);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(this);
        cameraBridgeViewBase.setCameraPermissionGranted();
        baseLoaderCallback = new BaseLoaderCallback(this) {
            @Override
            public void onManagerConnected(int status) {
                Log.i("Arrow","onManagerCOnnected");
                if (status == BaseLoaderCallback.SUCCESS) {
                    cameraBridgeViewBase.enableView();
                }else{
                    super.onManagerConnected(status);
                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ArrowApp","onResume");
        if(OpenCVLoader.initDebug()){
            Log.i("ArrowApp","initDebug");
            baseLoaderCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
            if (img == null){
//                img_id = getResources().getIdentifier("ue_seal_09","raw",getPackageName());
                img = BitmapFactory.decodeResource(getResources(),R.drawable.circle);
            }
        }else Log.i("ArrowApp","intDebug Fails");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cameraBridgeViewBase != null){
            cameraBridgeViewBase.disableView();
        }
    }

    // Permission Functions
    void getPermission(){
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA},102);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 102 && grantResults.length > 0){
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                getPermission();
            }
        }
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        screen_w = width;
        screen_h = height;
        gray = new Mat(screen_w,screen_h, CvType.CV_8UC1);
        mRgba = new Mat(screen_w,screen_h,CvType.CV_8SC4);
    }

    @Override
    public void onCameraViewStopped() {
        mRgba.release();
        gray.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();
        // process frame here

        mRgba = inputFrame.rgba();
        int w = mRgba.width();
        int h = mRgba.height();

        Imgproc.rectangle(mRgba, new Point(screen_w * 1 / 3, screen_h * 1 / 3), new Point(
                screen_w * 2 / 3, screen_h * 2 /  3 ), new Scalar( 0, 255, 0 ), -1);

        return mRgba;
    }
}