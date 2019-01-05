/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 * The ontology is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ontology is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.github.ontio.utils;

import com.github.ontio.OntSdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouq
 * @version 1.0
 * @date 2018/2/27
 */
public class ConstantParam {

    public static int HUGE_WIN_SIZE;
    public static String ONG_PLAYER_CODEHASH;

    public static String ONT_PLAYER_CODEHASH;

    public static int ONG_DECIMAL = 1000000000;

    public static OntSdk ONT_SDKSERVICE;

    public static List<String> MAINCHAIN_RPCLIST = new ArrayList<>();

    public static String MAINCHAIN_RPCURL;

    public static int MAINNODE_INDEX;

}
