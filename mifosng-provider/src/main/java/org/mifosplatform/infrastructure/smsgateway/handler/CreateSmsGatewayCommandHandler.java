package org.mifosplatform.infrastructure.smsgateway.handler;

import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.infrastructure.smsgateway.service.SmsGatewayWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSmsGatewayCommandHandler implements NewCommandSourceHandler {

    private final SmsGatewayWritePlatformService writePlatformService;

    @Autowired
    public CreateSmsGatewayCommandHandler(final SmsGatewayWritePlatformService writePlatformService) {
        this.writePlatformService = writePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {

        return this.writePlatformService.create(command);
    }
}
