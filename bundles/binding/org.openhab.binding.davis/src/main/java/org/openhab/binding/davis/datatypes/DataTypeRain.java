/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.davis.datatypes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.openhab.binding.davis.internal.Constants;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.types.State;

/**
 * Class to handle numeric values encoding rain based on rain clicks
 *
 * @author Trathnigg Thomas
 * @since 1.6.0
 */
public class DataTypeRain implements DavisDataType {

    /**
     * {@inheritDoc}
     */
    public State convertToState(byte[] data, DavisValueType valueType) {
        short value = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getShort(valueType.getDataOffset());
        return new DecimalType(value * Constants.RAIN_CLICK_BASE);
    }

}
