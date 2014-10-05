package org.apd.model.parsers;

import org.apd.model.domain.County;
import org.apd.model.domain.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocaleParser {
    private static String stateMappingFile = "/resources/States.txt";
    private static String countyMappingFile = "/resources/Counties.txt";
    private HashMap<String, State> statesByShortCode; // Key is state short code
    private HashMap<Integer, State> statesByInt; // Key is state short code
    private HashMap<String, County> countiesByStateAndCounty; // Key is state short code | county name, e.g. WA|King
    private HashMap<String, ArrayList<County>> countiesSetByState; // Key is state short code, result is list of all counties in state

    public LocaleParser() {
        this.setStatesByShortCode(new HashMap<String, State>());
        this.setStatesByInt(new HashMap<Integer, State>());
        this.setCountiesByStateAndCounty(new HashMap<String, County>());
        this.setCountiesSetByState(new HashMap<String, ArrayList<County>>());
        StateParser();
        CountyParser();
    }

    private void StateParser() {
        try {
            ArrayList<String> lines = ResourceReader.Read(this.stateMappingFile);
            for(String s : lines) {
                String[] split = s.split(",");
                State newState = new State(Integer.parseInt(split[0]), split[2].replace("\"", ""), split[1].replace("\"", ""));
                this.getStatesByShortCode().put(newState.getShortName(), newState);
                this.getStatesByInt().put(newState.getCode(), newState);
            }
        } catch(Exception e) {

        }
    }
    
    private void CountyParser() {
        try {
            ArrayList<String> lines = ResourceReader.Read(this.countyMappingFile);
            for(String s : lines) {
                String[] split = s.split(",");
                State state = this.getStatesByInt().get(Integer.parseInt(split[2]));
                County newCounty = new County(Integer.parseInt(split[0]), split[1].replace("\"", ""), state);
                this.getCountiesByStateAndCounty().put(state.getShortName() + "|" + newCounty.getName(), newCounty);
                ArrayList<County> counties = this.getCountiesSetByState().remove(state.getShortName());
                if(counties == null) {
                    counties = new ArrayList<County>();
                }

                counties.add(newCounty);
                this.getCountiesSetByState().put(state.getShortName(), counties);

            }
        } catch(Exception e) {

        }
    }

    public HashMap<String, County> getCountiesByStateAndCounty() {
        return countiesByStateAndCounty;
    }

    public void setCountiesByStateAndCounty(HashMap<String, County> countiesByStateAndCounty) {
        this.countiesByStateAndCounty = countiesByStateAndCounty;
    }

    public HashMap<String, State> getStatesByShortCode() {
        return statesByShortCode;
    }

    public void setStatesByShortCode(HashMap<String, State> statesByShortCode) {
        this.statesByShortCode = statesByShortCode;
    }

    public HashMap<Integer, State> getStatesByInt() {
        return statesByInt;
    }

    public void setStatesByInt(HashMap<Integer, State> statesByInt) {
        this.statesByInt = statesByInt;
    }

    public HashMap<String, ArrayList<County>> getCountiesSetByState() {
        return countiesSetByState;
    }

    public void setCountiesSetByState(HashMap<String, ArrayList<County>> countiesSetByState) {
        this.countiesSetByState = countiesSetByState;
    }
}
