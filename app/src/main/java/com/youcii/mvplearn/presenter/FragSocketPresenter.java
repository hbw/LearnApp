package com.youcii.mvplearn.presenter;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.youcii.mvplearn.service.PitPatService;
import com.youcii.mvplearn.utils.ToastUtils;
import com.youcii.mvplearn.fragment.interfaces.IFragSocketView;

/**
 * @author YouCii
 * @date 2016/12/3
 */
public class FragSocketPresenter {
	private Activity activity;

	private IFragSocketView iFragSocketView;
	private PitPatService pitPatService;

	private ServiceConnection connection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			pitPatService = ((PitPatService.ServiceBinder) service).getService();
			pitPatService.setSocketStateListener(socketStateListener);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) { // 此方法只有在service异常时才调用
			pitPatService = null;
		}
	};

	public FragSocketPresenter(Activity activity, IFragSocketView iFragSocketView) {
		this.iFragSocketView = iFragSocketView;
		this.activity = activity;
	}

	public void socketSend() {
		if (pitPatService != null) {
            pitPatService.sentMessage("message from client");
        }
	}

	public void socketBreak() {
		if (pitPatService != null) {
			// 会触发unBind()和onDestroy()
			activity.unbindService(connection);
			pitPatService = null;
		}
	}

	public void socketConnect() {
		Intent intent = new Intent(activity, PitPatService.class);
		intent.putExtra("IP", iFragSocketView.getIp());
		intent.putExtra("PORT", iFragSocketView.getPort());
		// 会触发onCreate()和onBind()，不触发onStartCommand； 多次点击不会多次触发
		activity.bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}

	public void socketCurrentThread() {
		ToastUtils.showShortSnack(activity.getWindow().getDecorView(), "待写");
	}

	private PitPatService.SocketStateListener socketStateListener = new PitPatService.SocketStateListener() {

		@Override
		public void onBreak() {
			activity.runOnUiThread(() -> iFragSocketView.addMessageText("连接已断开"));
		}

		@Override
		public void onConnect() {
			activity.runOnUiThread(() -> iFragSocketView.addMessageText("已连接"));
		}

		@Override
		public void onReceive(String string) {
			activity.runOnUiThread(() -> iFragSocketView.addMessageText("接收到消息：" + string));
		}

		@Override
		public void onSend(String string) {
			activity.runOnUiThread(() -> iFragSocketView.addMessageText("发送消息：" + string));
		}
	};

}