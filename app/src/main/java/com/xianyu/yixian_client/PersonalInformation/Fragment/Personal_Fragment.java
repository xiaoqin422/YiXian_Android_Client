package com.xianyu.yixian_client.PersonalInformation.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.xianyu.yixian_client.Core;
import com.xianyu.yixian_client.PersonalInformation.PersonalInformationViewModel;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.PersonalInformationPersonalFragmentBinding;

import org.w3c.dom.Text;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Login
 * @ClassName: Login_Fragment
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/18 21:51
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/18 21:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Personal_Fragment extends Fragment {
    public PersonalInformationViewModel viewModel;
    public PersonalInformationPersonalFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = PersonalInformationPersonalFragmentBinding.inflate(inflater,container,false);
        init();
        return binding.getRoot();
    }

    private void init() {
        TextView textView = binding.getRoot().findViewById(R.id.kills_text);
        textView.setText(Core.liveUser.getValue().getKills());
    }

    public Personal_Fragment(PersonalInformationViewModel viewModel){
        this.viewModel = viewModel;
    }
    @Override
    public void onDestroy() {
        onDestroyView();
        super.onDestroy();
    }
}
