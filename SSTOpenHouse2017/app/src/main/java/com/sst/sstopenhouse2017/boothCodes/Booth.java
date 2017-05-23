package com.sst.sstopenhouse2017.boothCodes;

import java.util.ArrayList;

enum Booth {
    // General
    GENERAL_Welcome_Booth("UJNX"),
    GENERAL_PforSST("G294"),
    GENERAL_Student_Projects("VYEY"),
    GENERAL_SSTed_Talks("ZZU5"),
    GENERAL_PVP_Talks("5SFT"),
    GENERAL_Student_Life_at_SST("FGGD"),
    GENERAL_Student_Panel("A3XP"),
    GENERAL_DSA_Booth("BUMW"),
    // Academic Booths
    ACADEMIC_Computing("GTPT"),
    ACADEMIC_Biotechnology("ARPT"),
    ACADEMIC_Design_Studies("QECY"),
    ACADEMIC_Electronics("59W9"),
    ACADEMIC_English_Language("NVXS"),
    ACADEMIC_GCP("6VMK"),
    ACADEMIC_I_and_E("NEGV"),
    ACADEMIC_Integrated_Humanities("M26V"),
    ACADEMIC_Interdisciplinary_Research_Studies("XSJY"),
    ACADEMIC_Mathematics("4LTL"),
    ACADEMIC_Mother_Tongue_Languages("U54N"),
    ACADEMIC_Science("J84Q"),
    ACADEMIC_S_and_W("MER7"),
    ACADEMIC_TDP("RCSY"),
    ACADEMIC_Youth_Service_Programme("M8YP"),
    // CCA Booths
    CCA_Astronomy("9BW6"),
    CCA_Football("6WJP"),
    CCA_Show_Choir("CX6E"),
    CCA_Taekwando("3SNC"),
    CCA_Floorball("RMXL"),
    CCA_Robotics("VXWZ"),
    CCA_Media_Club("CVL9"),
    // Science Hands On Sessions
    HANDS_ON_Biology("ADKZ"),
    HANDS_ON_Chemistry("5NW8"),
    HANDS_ON_Biotechnology("NAS5"),
    HANDS_ON_Science_TDP("JHUF"),
    HANDS_ON_Physics("C9ZJ"),
    HANDS_ON_Electronics("G7AQ");

    private final String boothCode;
    private static ArrayList<String> codes;

    Booth(String boothName) {
        this.boothCode = boothName;
    }

    String getBoothCode() {
        return this.boothCode;
    }

    public static ArrayList<String> getAllCodes() {
        if (codes == null) {
            codes = new ArrayList<>();
            for (Booth b : Booth.class.getEnumConstants()) {
                codes.add(b.getBoothCode());
            }
        }

        return codes;
    }
}