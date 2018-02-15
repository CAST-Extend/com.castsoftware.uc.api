package com.castsoftware.jenkins.util;

import hudson.EnvVars;
import hudson.model.EnvironmentContributingAction;
import hudson.model.InvisibleAction;
import hudson.model.AbstractBuild;

/**
 * An action to publish a single environment variable.
 */
public class PublishEnvVarAction extends InvisibleAction implements EnvironmentContributingAction
{

    /** The environment variable key. */
    private String key;

    /** The environment variable value. */
    private String value;
    
    /**
     * Constructor.
     * @param key the environment variable key
     * @param value the environment variable value
     */
    public PublishEnvVarAction(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    /* (non-Javadoc)
     * @see hudson.model.EnvironmentContributingAction#buildEnvVars(hudson.model.AbstractBuild, hudson.EnvVars)
     */
    public void buildEnvVars(AbstractBuild<?, ?> build, EnvVars env) {
        env.put(key, value);
    }


}
