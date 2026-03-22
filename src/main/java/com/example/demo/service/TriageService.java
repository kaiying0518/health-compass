package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HealthRecordForm;
import com.example.demo.dto.TriageResult;

@Service
public class TriageService {

    public TriageResult evaluate(HealthRecordForm form) {

        boolean dangerSign = Boolean.TRUE.equals(form.getDangerSign());
        Double temperature = form.getTemperature();
        Integer heartRate = form.getHeartRate();
        Integer oxygenLevel = form.getOxygenLevel();

        // 高リスク
        if (dangerSign || (oxygenLevel != null && oxygenLevel < 93)) {
            return new TriageResult(
                    "HIGH",
                    "少し心配な状態の可能性があります。ひとりで抱え込まず、早めに医療機関に相談してみてください。",
                    "可能であれば、できるだけ早く病院や救急外来へ連絡してください。"
            );
        }

        // 中リスク
        if ((temperature != null && temperature >= 38.5)
                || (heartRate != null && heartRate >= 110)) {
            return new TriageResult(
                    "MEDIUM",
                    "少し体に負担がかかっている可能性があります。無理をせず、様子を見ながら受診も検討してみてください。",
                    "時間のあるときに、内科や発熱外来での相談をおすすめします。"
            );
        }

        // 低リスク
        return new TriageResult(
                "LOW",
                "今のところ大きな心配はなさそうです。まずはゆっくり休んで、体調の変化を見てみてください。",
                "もし違和感が続いたり不安があれば、無理せず医療機関に相談してください。"
        );
    }
}
