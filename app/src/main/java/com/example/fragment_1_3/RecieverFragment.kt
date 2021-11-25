package com.example.fragment_1_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.fragment_1_3.databinding.FragmentRecieverBinding

class RecieverFragment : Fragment() {

    lateinit var binding:FragmentRecieverBinding
    //다른 매서드에서도 사용하기 위해 onCreateView 메서드 밖에 바인딩 생성
    //onCreateView() 메서드 안에서만 사용할 수 있는 파라미터가 필요하므로 미리 lateinit으로 선언만하고 진행
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecieverBinding.inflate(inflater, container, false)
        //onCreaateView() 메서드 안에서 바인딩을 생성해서 binding프로퍼티에 저장
        //binding프로퍼티에 바인딩을 저장했기 때문에 다른 메서드에서도 가져다 쓸 수 있음
        return binding.root
        //binding.root를 반환
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //onViewCreated 메서드를 오버라이드
        super.onViewCreated(view, savedInstanceState)
        
        setFragmentResultListener("request") { key, bundle ->
        //보내는 측 프래그먼트에서 "request"라는 키로 값을 보내면 이 리스너 안의 코드가 실행
        //리스너는 값을 수신하면 key와 bundle 2개의 파라미터를 사용 
            //실제 값은 bundle안에 Map의 형태로 담겨 있음
            //bundle.getString("키")로 값을 꺼낼 수 있음
            
            bundle.getString("valueKey")?.let {
            //꺼낸 값이 있을 때만 textView에 값을 세팅
                binding.textView.setText(it)
        }
        //request는 요청 전체에 대한 키
            //bundle.getString에 입력되는 "valuekey"는 요청에 담겨있는 값 중 하나의 값을 지칭
        }
    }
}