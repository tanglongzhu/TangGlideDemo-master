package cn.xm.weidongjian.glidedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    private ImageView imageView;
    private RequestManager glideRequest;
    private Context context = this;
    /**
     * https://www.baidu.com/img/bdlogo.png
     */
    private String imageurl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493781003&di=ec939caf35bd59f7c65bf26ac6dde741&imgtype=jpg&er=1&src=http%3A%2F%2Fimg01.taopic.com%2F141114%2F318762-1411140J63541.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);

        glideRequest = Glide.with(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                glideRequest.load(imageurl).into(imageView);
                break;
            case R.id.button2:
                glideRequest.load(imageurl).transform(new GlideRoundTransform(context)).into(imageView);
                break;
            case R.id.button3:
                glideRequest.load(imageurl).transform(new GlideRoundTransform(context, 50)).into(imageView);
                break;
            case R.id.button4:
                glideRequest.load(imageurl).transform(new GlideCircleTransform(context)).into(imageView);
                break;
        }
    }
}
