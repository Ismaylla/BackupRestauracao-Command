package commands;

import receivers.SecurityControl;

public class SecurityDisarmCommand implements Command {
    private SecurityControl security;

    public SecurityDisarmCommand(SecurityControl security) {
        this.security = security;
    }

    @Override
    public void execute() {
        security.disarm();
    }
}
