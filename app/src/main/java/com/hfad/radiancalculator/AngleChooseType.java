package com.hfad.radiancalculator;

public class AngleChooseType {

    private double m_degree = 0;

    public void setAngleValue(int angleValue, String degree) {
        switch (angleValue) {
            case (0):
            {
                m_degree = (Double.parseDouble(degree) * 180) / 200;
                break;
            }
            case (1):
            {
                m_degree = (Double.parseDouble(degree) * 180) / Math.PI;
                break;
            }
            case (2):
            {
                m_degree = (Double.parseDouble(degree) * 180) / (1000 * Math.PI);
                break;
            }
            case (3):
            {
                m_degree = Double.parseDouble(degree);
                break;
            }
        }
    }
    double getChooseAngle(int angleOther) {
        double degreeAngle = 0;
        switch (angleOther) {
            case (0):
            {
                degreeAngle = (m_degree * 200) / 180;
                break;
            }
            case (1):
            {
                degreeAngle = (m_degree * Math.PI) / 180;
                break;
            }
            case (2):
            {
                degreeAngle = (m_degree * 1000 * Math.PI) / 180;
                break;
            }
            case (3):
            {
                degreeAngle = m_degree;
                break;
            }
        }
        return degreeAngle;
    };
}
