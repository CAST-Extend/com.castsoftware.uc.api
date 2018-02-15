package com.castsoftware.jenkins.util;

import java.util.regex.Pattern;
import hudson.EnvVars;
import java.util.regex.Matcher;

public class EnvTemplater
{
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("(\\$\\{?[A-Za-z_]+\\}?)");
	private static final Pattern VARIABLE_NAME_PATTERN = Pattern.compile("([A-Za-z_]+)");

	private EnvVars vars = null;
	
	public EnvTemplater(EnvVars iVars)
	{
		vars = iVars;
	}
	
    /**
      * Given an input string, find environment var patterns and inject them into
      * the string from the current environment variables. The input of the string really
      * isn't important to this function, only the format of the variables within the string.
      * We look for two forms of variables:
      *  - $VAR_NAME
      *  - ${VAR_NAME}
      *
      * Note: The environment variables that we are using are not _true_ environment 
      * variables, but rather Jenkins Environment variables (the same ones you would normally 
      * use to template within a normal Jenkins job).
      *
      * @param input The input string to be templated (possibly containing variable 
      *              expressions)
      * @param vars  The vars to use to inject into the input string
      * @return      A string where the variables have been replaced by Jenkins evn variable 
      *              value, if the variable exists.
      */
    public String templateString(String input) 
    {
        if (vars == null || input == null) {
            return input;
        }

        String output = input;
        Matcher match = VARIABLE_PATTERN.matcher(input);
        int replacementOffset = 0;

        // iterate through all of the variables that we find
        while (match.find()) {

            // find the variable name (without the $ and {} characters)
            String matchGroup = match.group();
            Matcher varNameMatcher = VARIABLE_NAME_PATTERN.matcher(matchGroup);
            while (varNameMatcher.find()) {
                // pull out variable name, replace using bounds of outer `match`
                String varNameMatchGroup = varNameMatcher.group(1);
                int startPos = match.start(1);
                int endPos = match.end(1);
                if (vars.containsKey(varNameMatchGroup)) {
                    String replacement = vars.get(varNameMatchGroup, matchGroup);
                    output = output.substring(0, replacementOffset + startPos)
                            + replacement
                            + output.substring(replacementOffset + endPos, output.length());

                    // replacement offset is used during string replacement to account for 
                    // the string growing or shrinking as we replace values (and the regex 
                    // positions being out of date).
                    replacementOffset +=  replacement.length() - (endPos - startPos);
                }
            }
        }
        return output;
    }
}	

