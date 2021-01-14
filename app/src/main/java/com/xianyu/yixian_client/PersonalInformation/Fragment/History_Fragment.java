package com.xianyu.yixian_client.PersonalInformation.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xianyu.yixian_client.PersonalInformation.Fragment.Adapt.HistoryAdapt;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.PersonalInformationHistoryFragmentBinding;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
@AndroidEntryPoint
public class History_Fragment extends Fragment  {
    public PersonalInformationViewModel viewModel;
    public PersonalInformationHistoryFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = PersonalInformationHistoryFragmentBinding.inflate(inflater,container,false);
        init();
        return binding.getRoot();
    }

    private void init() {
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.history_list);

    }

    public History_Fragment(PersonalInformationViewModel viewModel){
        this.viewModel = viewModel;
    }
    @Override
    public void onDestroy() {
        onDestroyView();
        super.onDestroy();
    }
}
