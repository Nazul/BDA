/*
 * Copyright 2016 Mario Contreras - marioc@nazul.net.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.iteso.msc.bda.banksimulator.entities;

import java.util.stream.Stream;

/**
 *
 * @author Mario Contreras - marioc@nazul.net
 */
public enum TransferStatus {
    INITIAL,
    PENDING,
    APPLIED,
    DONE,
    CANCELED,
    ERROR;
    
    public static String[] names() {
        return Stream.of(TransferStatus.values()).map(TransferStatus::name).toArray(String[]::new);
    }
};

// EOF
