package ca.mcmaster.island.BiomeGeneration.whittakerBiomeGen;

import java.lang.Math;
public class percipitationCalculator {
    public int hieghtPercipitation(int hieght, int per){
        int Percipitation = per + (int)0.5*hieght;
        System.out.printf("P: %d\n",Percipitation);
        return Percipitation;
    }
}
