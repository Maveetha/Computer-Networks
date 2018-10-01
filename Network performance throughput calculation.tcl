set val(chan) Channel/WirelessChannel
set val(prop) Propagation/TwoRayGround
set val(netif) Phy/WirelessPhy
set val(mac) Mac/802_11
set val(ifq) Queue/DropTail/PriQueue
set val(ll) LL
set val(ant) Antenna/OmniAntenna
set val(ifqlen) 50
set val(nn) 3
set val(rp) DSDV
set ns [new Simulator]

set tf [open wireless.tr w]
$ns trace-all $tf

set tf1 [open wireless1.nam w]
$ns namtrace-all-wireless $tf1 500 500

set topo [new Topography]
$topo load_flatgrid 500 500

create-god $val(nn)

$ns node-config -adhocRouting $val(rp) \
-llType $val(ll) \
-macType $val(mac) \
-ifqType $val(ifq) \
-ifqLen $val(ifqlen) \
-antType $val(ant) \
-propType $val(prop) \
-phyType $val(netif) \
-channelType $val(chan) \
-topoInstance $topo \
-agentTrace ON \
-routerTrace OFF \
-macTrace OFF \
-movementTrace OFF 

set node0 [$ns node]
set node1 [$ns node]
set node2 [$ns node]

$ns initial_node_pos $node0 10
$ns initial_node_pos $node1 10
$ns initial_node_pos $node2 10

$node0 set X_ 5.0
$node0 set Y_ 5.0
$node0 set Z_ 0.0

$node1 set X_ 50.0
$node1 set Y_ 50.0
$node1 set Z_ 0.0

$node2 set X_ 100.0
$node2 set Y_ 100.0
$node2 set Z_ 0.0

set udp1 [new Agent/UDP]
$ns attach-agent $node0 $udp1

set cbr1 [new Application/Traffic/CBR]
$cbr1 attach-agent $udp1

set null1 [new Agent/Null]
$ns attach-agent $node2 $null1

$ns connect $udp1 $null1

$ns at 0.0 "$node0 setdest 5.0 10.0 0.0"
$ns at 0.0 "$node2 setdest 300.0 300.0 0.0"
$ns at 30.0 "$node1 setdest 30.0 300.0 0.0"
$ns at 50.0 "$node1 setdest 50.0 50.0 0.0"

$ns at 0.5 "$cbr1 start"
$ns at 159 "$cbr1 stop"

$ns at 160 "finish"

proc finish {} {
global ns tf tf1
$ns flush-trace
close $tf
close $tf1
exec nam wireless1.nam &
exit 0
}

$ns run

out.awk:

BEGIN { 
Print “Throughput Calculation”
}

{
if (( $1 == “r” && $7 == “cbr” && $3 == “_2_“ ))
{
pkts = pkts + $8;
}

}

END {
Throughput  = pkts * 8 / $2 /1000000
print “Throughput = “ Throughput
}

out1.awk:

{
if (( $1 == “r” && $7 == “cbr” && $3 == “_2_“ ))
{
pkts = pkts + 8;
print $2, pkts * 8/ $2 / 1000000
}
}
