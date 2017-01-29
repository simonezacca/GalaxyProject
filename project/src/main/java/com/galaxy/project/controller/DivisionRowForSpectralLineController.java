package com.galaxy.project.controller;

import com.galaxy.project.frames.DivisionRowForSpectralLineApertureFrame;
import com.galaxy.project.frames.DivisionRowForSpectralLineFrame;
import com.galaxy.project.frames.DivisionRowFrame;
import com.galaxy.project.frames.ValuesSpectralLineFrame;

public class DivisionRowForSpectralLineController {

	DivisionRowForSpectralLineFrame valuesDivisionRowForSpectralLineFrame = null;
	DivisionRowForSpectralLineApertureFrame valuesDivisionRowForSpectralLineApertureFrame = null;

	public DivisionRowForSpectralLineController(DivisionRowForSpectralLineFrame parent){
		this.valuesDivisionRowForSpectralLineFrame = parent; 	
	}
	
	public DivisionRowForSpectralLineController(DivisionRowForSpectralLineApertureFrame parent){
		this.valuesDivisionRowForSpectralLineApertureFrame = parent; 	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
