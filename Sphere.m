//
//  Sphere.m
//  
//
//  Created by Chelsea on 3/2/14.
//
//

#import "Sphere.h"

@implementation Sphere


-(void)setRadius:(float)radius{
    _radius = radius;
}

-(float)radius {
    return _radius;
}

-(void)setCenter:(NSArray *)center{
    _center = center;
}

-(NSArray *)center{
    return _center;
}

@end
