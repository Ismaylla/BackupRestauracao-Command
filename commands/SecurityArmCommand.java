package commands;

import receivers.SecurityControl;

public class SecurityArmCommand implements Command {
    private SecurityControl security;

    public SecurityArmCommand(SecurityControl security) {
        this.security = security;
    }

    @Override
    public void execute() {
        security.arm();
    }
}
