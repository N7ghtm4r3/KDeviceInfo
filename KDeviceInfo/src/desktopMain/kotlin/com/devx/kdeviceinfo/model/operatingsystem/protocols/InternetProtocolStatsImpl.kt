package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.*
import oshi.SystemInfo

class InternetProtocolStatsImpl: InternetProtocolStats {

    private val stats by lazy { SystemInfo().operatingSystem.internetProtocolStats }

    override val TCPv4Stats: TcpStats
        get() = initTcpStats(
            source = stats.tcPv4Stats
        )

    override val TCPv6Stats: TcpStats
        get() = initTcpStats(
            source = stats.tcPv6Stats
        )

    override val UDPv4Stats: UdpStats
        get() = initUdpStats(
            source = stats.udPv4Stats
        )

    override val UDPv6Stats: UdpStats
        get() = initUdpStats(
            source = stats.udPv6Stats
        )

    override val IPConnection: List<IPConnection>
        get() = loadIpConnections(
            sourceList = stats.connections
        )

    private fun initTcpStats(
        source: oshi.software.os.InternetProtocolStats.TcpStats
    ) : TcpStats {
        return TcpStatsImpl(
            connectionsEstablished = source.connectionsEstablished,
            connectionsActive = source.connectionsActive,
            connectionsPassive = source.connectionsPassive,
            connectionFailures = source.connectionFailures,
            connectionsReset = source.connectionsReset,
            segmentsSent = source.segmentsSent,
            segmentsReceived = source.segmentsReceived,
            segmentsRetransmitted = source.segmentsRetransmitted,
            inErrors = source.inErrors,
            outResets = source.outResets
        )
    }

    private fun initUdpStats(
        source: oshi.software.os.InternetProtocolStats.UdpStats
    ) : UdpStats {
        return UdpStatsImpl(
            datagramsSent = source.datagramsSent,
            datagramsReceived = source.datagramsReceived,
            datagramsNoPort = source.datagramsNoPort,
            datagramsReceivedErrors = source.datagramsReceivedErrors
        )
    }

    private fun loadIpConnections(
        sourceList: List<oshi.software.os.InternetProtocolStats.IPConnection>
    ) : List<IPConnection> {
        val result = mutableListOf<IPConnection>()
        sourceList.forEach { connection ->
            result.add(
                IPConnectionImpl(
                    type = connection.type,
                    localAddress = connection.localAddress,
                    localPort = connection.localPort,
                    foreignAddress = connection.foreignAddress,
                    foreignPort = connection.foreignPort,
                    state = TcpState.valueOf(connection.state.name),
                    transmitQueue = connection.transmitQueue,
                    receiveQueue = connection.receiveQueue,
                    owningProcessId = connection.getowningProcessId()
                )
            )
        }
        return result
    }

}