package ca.mcmaster.pathfinder.Configuration;

import org.apache.commons.cli.*;

public class Configuration {

    public static final String OUTPUT = "o";
    public static final String INPUT = "i";
    public static final String SIZE = "size";
    public static final String CITYNUM = "cityNum";



    private CommandLine cli;

    public Configuration(String[] args) {
        try {
            this.cli = parser().parse(options(), args);
        } catch (ParseException pe) {
            throw new IllegalArgumentException(pe);
        }
    }

    private CommandLineParser parser() {
        return new DefaultParser();
    }

    public String input() {
        return this.cli.getOptionValue(INPUT);
    }

    public String output() {
        return this.cli.getOptionValue(OUTPUT, "output.svg");
    }
    public String size() {
        return this.cli.getOptionValue(SIZE, "small");
    }
    public String cityNum() {
        return this.cli.getOptionValue(CITYNUM, "5");
    }



    private Options options() {
        Options options = new Options();
        options.addOption(new Option(INPUT, true, "Input file (SVG)"));
        options.addOption(new Option(OUTPUT, true, "Output file (MESH)"));
        options.addOption(new Option(SIZE, true, "City sizes, \'small\', \'medium\', or \'large\'"));
        options.addOption(new Option(CITYNUM, true, "Number of cities"));
        return options;
    }


}
